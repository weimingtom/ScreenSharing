/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.huan.administrator.screensharing;

import android.app.Activity;
import android.os.Bundle;

import com.huan.administrator.screensharing.udp.bean.DiscoveryServer;

/*
 * MainActivity class that loads MainFragment
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = MainActivity.this;
        startServer();
    }

    private DiscoveryServer udpServer;
    private MainActivity context;
    protected void startServer() {
        udpServer = new DiscoveryServer(android.os.Build.MODEL);
        udpServer.start();
    }

    @Override
    protected void onDestroy() {

        if(udpServer != null){
            udpServer.interrupt();
            udpServer = null;
        }
        super.onDestroy();
    }

}
