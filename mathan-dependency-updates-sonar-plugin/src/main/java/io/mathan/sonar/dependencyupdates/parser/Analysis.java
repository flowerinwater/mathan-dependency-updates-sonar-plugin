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
package io.mathan.sonar.dependencyupdates.parser;

import java.util.ArrayList;
import java.util.List;

public class Analysis {

  private int nextIncrementalAvailable = 0;
  private int nextMinorAvailable = 0;
  private int nextMajorAvailable = 0;

  private List<Dependency> dependencyManagements = new ArrayList<>();
  private List<Dependency> dependencies = new ArrayList<>();

  public List<Dependency> getDependencies() {
    return dependencies;
  }

  public List<Dependency> getDependencyManagements() {
    return dependencyManagements;
  }

  public int getNextIncrementalAvailable() {
    return nextIncrementalAvailable;
  }

  public int getNextMajorAvailable() {
    return nextMajorAvailable;
  }

  public int getNextMinorAvailable() {
    return nextMinorAvailable;
  }

  void finish() {
    this.nextIncrementalAvailable = Math.toIntExact((dependencyManagements.stream().filter(dependency -> dependency.getIncrementals().size()>0).count()
        +dependencies.stream().filter(dependency -> dependency.getIncrementals().size()>0).count()));
    this.nextMinorAvailable = Math.toIntExact((dependencyManagements.stream().filter(dependency -> dependency.getMinors().size()>0).count()
        +dependencies.stream().filter(dependency -> dependency.getMinors().size()>0).count()));
    this.nextMajorAvailable = Math.toIntExact((dependencyManagements.stream().filter(dependency -> dependency.getMajors().size()>0).count()
        +dependencies.stream().filter(dependency -> dependency.getMajors().size()>0).count()));
  }
}
