/*
 * Created by zhangxiangwei on 2020/09/09.
 * Copyright 2015－2020 Sensors Data Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sensorsdata.abtest;

interface ISensorsABTestApi {

    /**
     * 从缓存中获取试验结果
     *
     * @param experimentId 试验id
     * @param defaultValue 默认值
     * @param <T> 默认值类型
     * @return 缓存获取试验变量
     */
    <T> T fetchCacheABTest(String experimentId, T defaultValue);

    /**
     * 始终从网络请求试验结果，默认 30s 超时时间
     *
     * @param experimentId 试验id
     * @param defaultValue 默认值
     * @param callBack 接口回调
     * @param <T> 默认值类型
     */
    <T> void asyncFetchABTest(String experimentId, T defaultValue, OnABTestReceivedData<T> callBack);

    /**
     * 始终从网络请求试验结果，可自定义超时时间
     *
     * @param experimentId 试验id
     * @param defaultValue 默认值
     * @param timeoutMillSeconds 超时时间，单位毫秒
     * @param callBack 接口回调
     * @param <T> 默认值类型
     */
    <T> void asyncFetchABTest(String experimentId, T defaultValue, int timeoutMillSeconds, OnABTestReceivedData<T> callBack);

    /**
     * 如果本地有缓存，则返回缓存数据；否则从网络请求最新的实验数据，默认 30s 超时时间
     *
     * @param experimentId 试验id
     * @param defaultValue 默认值
     * @param callBack 接口回调
     * @param <T> 默认值类型
     */
    <T> void fastFetchABTest(String experimentId, T defaultValue, OnABTestReceivedData<T> callBack);

    /**
     * 如果本地有缓存，则返回缓存数据；否则从网络请求最新的实验数据，可自定义超时时间
     *
     * @param experimentId 试验id
     * @param defaultValue 默认值
     * @param timeoutMillSeconds 超时时间，单位毫秒
     * @param callBack 接口回调
     * @param <T> 默认值类型
     */
    <T> void fastFetchABTest(String experimentId, T defaultValue, int timeoutMillSeconds, OnABTestReceivedData<T> callBack);
}
