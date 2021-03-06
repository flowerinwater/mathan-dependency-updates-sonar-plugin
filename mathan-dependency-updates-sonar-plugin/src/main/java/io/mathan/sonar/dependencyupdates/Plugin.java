/*
 * mathan-dependency-updates-sonar-plugin
 * Copyright (c) 2019 Matthias Hanisch
 * matthias@mathan.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mathan.sonar.dependencyupdates;

import io.mathan.sonar.dependencyupdates.rule.MathanLanguage;
import io.mathan.sonar.dependencyupdates.rule.MathanProfile;
import io.mathan.sonar.dependencyupdates.rule.UsingOutdatedDepencencies;
import java.util.Arrays;

public final class Plugin implements org.sonar.api.Plugin {

  @Override
  public void define(Context context) {
    context.addExtensions(Arrays.asList(
        Sensor.class,
        Metrics.class,
        MathanProfile.class,
        MathanLanguage.class,
        UsingOutdatedDepencencies.class
        )
    );
    context.addExtensions(Configuration.getPropertyDefinitions());
  }
}
