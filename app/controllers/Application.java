package controllers;

import models.Task;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    static Form<Task> taskForm = Form.form(Task.class);

    public static Result index() {
        return redirect(routes.Application.tasks());
    }

    public static Result tasks() {
        return ok(index.render(Task.all(), taskForm));
    }

    public static Result newTask() {
        Form<Task> form = taskForm.bindFromRequest();
        if(form.hasErrors()) {
            return badRequest(index.render(Task.all(), taskForm));
        } else {
            Task.create(form.get());
            return redirect(routes.Application.tasks());
        }
    }

    public static Result deleteTask(Long id) {
        Task.delete(id);
        return redirect(routes.Application.tasks());
    }
}
