package hello.servlet.web.frontControllerRetries.v3.Controller;

import hello.servlet.web.frontControllerRetries.ModelView;
import hello.servlet.web.frontControllerRetries.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
