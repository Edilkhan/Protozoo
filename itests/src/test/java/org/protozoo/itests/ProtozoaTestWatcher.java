/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.protozoo.itests;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtozoaTestWatcher extends TestWatcher {

    private static final Logger LOG = LoggerFactory.getLogger(ProtozoaTestWatcher.class);

    @Override
    protected void starting(Description description) {
        LOG.info(">>>>>> {} <<<<<" , description.getDisplayName());
    }

    @Override
    protected void failed(Throwable e, Description description) {
        LOG.error(">>>>>> FAILED: {} , cause: {}", description.getDisplayName(), e.getMessage());
    }

    @Override
    protected void succeeded(Description description) {
    }


}