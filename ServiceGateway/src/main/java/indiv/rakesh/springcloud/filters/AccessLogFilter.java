/**
 * 
 */
package indiv.rakesh.springcloud.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author rakesh.malireddy
 *
 */
@Component
public class AccessLogFilter extends ZuulFilter {
	
	 Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);


	@Override
	public Object run() {	
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
	}


	@Override
	public boolean shouldFilter() {		
		return true;
	}


	@Override
	public int filterOrder() {		
		return 0;
	}


	@Override
	public String filterType() {	 
		return "pre";
	}

}
