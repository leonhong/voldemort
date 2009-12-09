/*
 * Copyright 2008-2009 LinkedIn, Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package voldemort.cluster.failuredetector;

import voldemort.utils.Time;
import voldemort.utils.Utils;

/**
 * Holds the status of a node--either available or unavailable as well as the
 * last date the status was checked.
 * 
 * Operations on this class are not atomic, but that is okay.
 * 
 * @author jay
 * 
 */
class NodeStatus {

    private final Time time;

    private long lastChecked;

    private boolean isAvailable;

    private long startMillis;

    private long success;

    private long total;

    public NodeStatus(Time time) {
        long currTime = time.getMilliseconds();

        this.time = Utils.notNull(time);
        this.lastChecked = currTime;
        this.startMillis = currTime;
        this.isAvailable = true;
    }

    public long getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(long lastChecked) {
        this.lastChecked = lastChecked;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
        this.lastChecked = time.getMilliseconds();
    }

    public long getStartMillis() {
        return startMillis;
    }

    public void setStartMillis(long startMillis) {
        this.startMillis = startMillis;
    }

    public long getSuccess() {
        return success;
    }

    public void setSuccess(long success) {
        this.success = success;
    }

    public void incrementSuccess(long delta) {
        this.success += delta;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void incrementTotal(long delta) {
        this.total += delta;
    }

    public Time getTime() {
        return time;
    }

}