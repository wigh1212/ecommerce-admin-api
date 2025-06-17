package org.eppay.api.common.json;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.eppay.api.util.AgentUtils;


public class ContentTypeSwitchableMappingJackson2JsonView extends MappingJackson2JsonView {
    private static final String TEXT_PLAIN = "text/plain";

    public ContentTypeSwitchableMappingJackson2JsonView() {
        super();
    }

    @Override
    protected void setResponseContentType(HttpServletRequest request, HttpServletResponse response) {
        if (AgentUtils.isExplorer(request)) {
            response.setContentType(TEXT_PLAIN);
        } else {
            super.setResponseContentType(request, response);
        }
    }
}
