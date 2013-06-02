package fr.meehome.user.webapp.util;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.InternalResourceView;

public class JstlView extends InternalResourceView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dispatcherPath = prepareForRendering(request, response);

        // set original view being asked for as a request parameter
        request.setAttribute("content", dispatcherPath.substring(dispatcherPath.lastIndexOf("/") + 1));

        // force everything to be template.jsp
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/template/template.jsp");
        rd.include(request, response);
    }
}
