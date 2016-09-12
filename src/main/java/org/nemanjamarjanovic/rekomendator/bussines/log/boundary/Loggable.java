package org.nemanjamarjanovic.rekomendator.bussines.log.boundary;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * @author nemanja.marjanovic
 */
@InterceptorBinding
@Retention(RUNTIME)
@Target(
{
    METHOD, TYPE
})
public @interface Loggable
{
}
