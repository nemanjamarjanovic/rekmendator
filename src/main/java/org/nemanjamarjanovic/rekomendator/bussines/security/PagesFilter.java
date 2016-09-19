package org.nemanjamarjanovic.rekomendator.bussines.security;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebFilter("/faces/pages/*")
@Loggable
public class PagesFilter implements Filter
{

    @Inject
    CurrentUser currentUser;

    @Inject
    ServletContext servletContext;

    @Inject
    Logger log;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        String uri = ((HttpServletRequest) request).getRequestURI();
        String[] split = uri.split("/");
        String page = split[4].replace(".xhtml", "").toUpperCase();

        log.log(Level.INFO, "User: {0}", (currentUser.getName() != null) ? currentUser.getName() : "GUEST");
        log.log(Level.INFO, "Requested page: {0}", ((HttpServletRequest) request).getRequestURI());
        log.log(Level.INFO, "Needed permission: {0}", page);

        if (currentUser.getName() != null) {
            if (currentUser.getPages().stream().map(f -> f.getTitle()).anyMatch(f -> f.equals(page))
                    || currentUser.getPermissions().contains(page)) {

                chain.doFilter(request, response);
                return;
            }
        }
        else if (page.equals("USER-REGISTRATION")
                || (request.getParameter("src").equals("search") && uri.contains("movie-list.xhtml"))) {
            chain.doFilter(request, response);
            return;
        }

        log.log(Level.INFO, "ACCES DENIED :)");
        ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/faces/index.xhtml");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void destroy()
    {
    }

}
