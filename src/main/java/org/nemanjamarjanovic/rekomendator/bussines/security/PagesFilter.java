package org.nemanjamarjanovic.rekomendator.bussines.security;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;
import org.nemanjamarjanovic.rekomendator.presentation.CurrentUser;

/**
 *
 * @author nemanja.marjanovic
 */
@WebFilter("/afaces/pages/*")
@Loggable
public class PagesFilter implements Filter {

    @Inject
    CurrentUser currentUser;

    @Inject
    ServletContext servletContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String uri = ((HttpServletRequest) request).getRequestURI();
        String[] split = uri.split("/");
        String page = split[4].replace(".xhtml", "").toUpperCase();

        if (page.equals("USER-REGISTRATION")
                || page.equals("MOVIE-LIST")
                || currentUser.hasPermission(page)) {

            chain.doFilter(request, response);

        } else {
            ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/faces/index.xhtml");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
