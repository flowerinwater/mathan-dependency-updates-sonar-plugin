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
package io.mathan.sonar.dependencyupdates.rule;

import io.mathan.sonar.dependencyupdates.Constants;
import org.sonar.api.resources.AbstractLanguage;

public class MathanLanguage extends AbstractLanguage {

  public MathanLanguage() {
    super(Constants.LANGUAGE_KEY, "mathan");
  }

  @Override
  public String[] getFileSuffixes() {
    return new String[0];
  }

}
