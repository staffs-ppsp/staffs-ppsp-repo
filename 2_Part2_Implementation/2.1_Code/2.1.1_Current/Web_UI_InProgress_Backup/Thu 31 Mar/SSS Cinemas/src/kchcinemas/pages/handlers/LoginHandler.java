package kchcinemas.pages.handlers;

import kchcinemas.TemplateEngine;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import kchcinemas.PropertyList;
import kchcinemas.RequestHandler;
import kchcinemas.Response;
import kchcinemas.ResponseFactory;
import kchcinemas.Session;
import kchcinemas.gateway.Gateway;

/**
 *
 * @author darthcrap
 */
public class LoginHandler extends RequestHandler {
	@Override
	public Response getResponse(Session objSession, PropertyList plProperties, Matcher objMatcher) throws IOException {
		if (objSession.isLoggedIn()) {
			return TemplateEngine.produce(objSession, "kchcinemas/pages/data/loggedin.page",new PropertyList());
		}
		else {
			PropertyList plTemplateProperties = new PropertyList();

			if (plProperties.containsKey("username") && plProperties.containsKey("password")) {
				if (objSession.login(plProperties.get("username"),plProperties.get("password"))) {
					return ResponseFactory.createRedirectResponse("/login",objSession);
				}
				else {
					plTemplateProperties.add("template-error-display", "display");
					plTemplateProperties.add("template-error-title", "Could Not Login");
					plTemplateProperties.add("template-error-message", "Invalid Credentials");
				}
			}

			return TemplateEngine.produce(objSession, "kchcinemas/pages/data/login.page",plTemplateProperties);
		}
	}

	@Override
	public boolean needsUser() {
		return false;
	}

	@Override
	public boolean needsSession() {
		return true;
	}
}
