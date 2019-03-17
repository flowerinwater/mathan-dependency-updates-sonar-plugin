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

import java.util.Arrays;
import java.util.List;
import org.sonar.api.PropertyType;
import org.sonar.api.batch.ScannerSide;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.rule.Severity;

@ScannerSide
public class Configuration {

  private Configuration() {
    // do nothing
  }

  static List<PropertyDefinition> getPropertyDefinitions() {
    return Arrays.asList(
        PropertyDefinition.builder(Constants.REPORT_PATH_PROPERTY)
            .subCategory("Paths")
            .name("Dependency-Updates report path")
            .description("path to the 'dependency-updates-report.xml' file")
            .defaultValue(Constants.REPORT_PATH_DEFAULT)
            .build(),
        PropertyDefinition.builder(Constants.UPDATE_INCREMENTAL)
            .subCategory(Constants.SUB_CATEGORY_UPDATES)
            .name("Incremental updates")
            .description("Severity used for available incremental updates")
            .options(Severity.ALL)
            .defaultValue(Constants.UPDATE_INCREMENTAL_DEFAULT)
            .type(PropertyType.SINGLE_SELECT_LIST)
            .build(),
        PropertyDefinition.builder(Constants.UPDATE_MINOR)
            .subCategory(Constants.SUB_CATEGORY_UPDATES)
            .name("Minor updates")
            .description("Severity used for available minor updates")
            .options(Severity.ALL)
            .defaultValue(Constants.UPDATE_MINOR_DEFAULT)
            .type(PropertyType.SINGLE_SELECT_LIST)
            .build(),
        PropertyDefinition.builder(Constants.UPDATE_MAJOR)
            .subCategory(Constants.SUB_CATEGORY_UPDATES)
            .name("Major updates")
            .description("Severity used for available major updates")
            .options(Severity.ALL)
            .defaultValue(Constants.UPDATE_MAJOR_DEFAULT)
            .type(PropertyType.SINGLE_SELECT_LIST)
            .build()
    );
  }
}
