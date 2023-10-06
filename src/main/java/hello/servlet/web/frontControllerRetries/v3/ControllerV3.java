package hello.servlet.web.frontControllerRetries.v3;

import hello.servlet.web.frontControllerRetries.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
