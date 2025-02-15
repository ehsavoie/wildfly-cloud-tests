/*
 * JBoss, Home of Professional Open Source.
 *  Copyright 2022 Red Hat, Inc., and individual contributors
 *  as indicated by the @author tags.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.wildfly.test.cloud.env.vars.override;

import static io.dekorate.kubernetes.annotation.ImagePullPolicy.Always;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.dekorate.docker.annotation.DockerBuild;
import io.dekorate.kubernetes.annotation.Container;
import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Port;

@KubernetesApplication(
        envVars = {
                @Env(name = "WILDFLY_OVERRIDING_ENV_VARS", value = "1"),
                @Env(name = "SUBSYSTEM_LOGGING_ROOT_LOGGER_ROOT__LEVEL", value = "DEBUG"),
                @Env(name = "TEST_EXPRESSION_FROM_PROPERTY", value = "testing123")
        },
        imagePullPolicy = Always)
@ApplicationPath("")
public class EnvVarsOverrideApp extends Application {

}
