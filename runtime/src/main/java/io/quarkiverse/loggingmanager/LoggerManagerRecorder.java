package io.quarkiverse.loggingmanager;

import io.quarkus.runtime.annotations.Recorder;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

@Recorder
public class LoggerManagerRecorder {

    public Handler<RoutingContext> loggerHandler() {
        return new LoggerHandler();
    }

    public Handler<RoutingContext> levelHandler() {
        return new LevelHandler();
    }

    public Handler<RoutingContext> uiHandler(String loggingManagerFinalDestination, String loggingManagerPath,
            LoggingManagerRuntimeConfig runtimeConfig) {

        if (runtimeConfig.enable) {
            return new LoggingManagerStaticHandler(loggingManagerFinalDestination, loggingManagerPath);
        } else {
            return new LoggingManagerNotFoundHandler();
        }
    }

}
