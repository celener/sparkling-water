/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.spark.ml.h2o.param

import org.apache.spark.ml.param._

/**
  * Parameters which need to be available on the model itself for prediction purposes. This can't be backed
  * byt H2OAlgoParamsHelper as at the time of prediction we might be using mojo and binary parameters are not available.
  */
trait H2OMOJOPipelineModelParams extends Params {

  //
  // Param definitions
  //
  final val namedMojoOutputColumns: Param[Boolean] = new Param[Boolean](this, "namedMojoOutputColumns", "Mojo Output is not stored" +
    " in the array but in the properly named columns")

  //
  // Default values
  //
  setDefault(namedMojoOutputColumns -> true)

  //
  // Getters
  //
  /** @group getParam */
  def getNamedMojoOutputColumns() = $(namedMojoOutputColumns)

  //
  // Setters
  //
  /** @group setParam */
  def setNamedMojoOutputColumns(value: Boolean): this.type = set(namedMojoOutputColumns, value)

}
