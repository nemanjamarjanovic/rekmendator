package org.nemanjamarjanovic.rekomendator.bussines;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nemanjamarjanovic.rekomendator.presentation.UserContext;

/**
 *
 * @author nemanja.marjanovic
 */
@WebFilter("/faces/user/*")
public class UserPagesFilter implements Filter
{

    @Inject
    UserContext userContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {

        if (userContext.hasPermission("USER-PAGES")) {
            chain.doFilter(request, response);
        }
        else {
            ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/faces/index.xhtml");
        }
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
