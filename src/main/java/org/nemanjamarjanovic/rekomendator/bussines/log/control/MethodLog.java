package org.nemanjamarjanovic.rekomendator.bussines.log.control;



import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.nemanjamarjanovic.rekomendator.bussines.log.boundary.Loggable;

/**
 * @author nemanja.marjanovic
 */
@Loggable
@Interceptor
public class MethodLog {
    @Inject
    Logger logger;

    @AroundInvoke
    private Object logMethod(InvocationContext invocationContext) throws Exception {

        String resourceName = invocationContext.getTarget().getClass().getName();
        String methodName = invocationContext.getMethod().getName();
        StringBuilder sb = new StringBuilder();
        for (Object parameter : invocationContext.getParameters()) {
            sb.append(String.valueOf(parameter));
        }
        String parameters = sb.toString();

        try {
            logger.log(Level.INFO,
                    "CLASS: {0} METHOD: {1} PARAMETERS: {2}",
                    new Object[]{resourceName, methodName, parameters});
        } catch (Exception e) {
        }

        Object result = invocationContext.proceed();

        try {
            logger.log(Level.INFO,
                    "CLASS: {0} METHOD: {1} RESULT: {2}",
                    new Object[]{resourceName, methodName, String.valueOf(result)});
        } catch (Exception e) {
        }

        return result;
    }
}
