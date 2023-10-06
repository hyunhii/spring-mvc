package hello.servlet.web.frontControllerRetries.v3;

import hello.servlet.web.frontControllerRetries.ModelView;
import hello.servlet.web.frontControllerRetries.MyView;
import hello.servlet.web.frontControllerRetries.v3.Controller.MemberFormControllerV3;
import hello.servlet.web.frontControllerRetries.v3.Controller.MemberListControllerV3;
import hello.servlet.web.frontControllerRetries.v3.Controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV3", urlPatterns = "/front-controller/retries/v3/*")
public class FrontControllerV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerV3() {
        controllerMap.put("/front-controller/retries/v3/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/retries/v3/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/retries/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);


        HashMap<String, String> requestParamMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> requestParamMap.put(paramName, request.getParameter(paramName)));

        ModelView modelView = controller.process(requestParamMap);

        String viewName = modelView.getViewName();
        String viewPath = "/WEB-INF/views/" + viewName + ".jsp";
        MyView myView = new MyView(viewPath);

        myView.render(modelView.getModel(), request, response);
    }
}
