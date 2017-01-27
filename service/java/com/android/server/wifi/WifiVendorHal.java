/*
 * Copyright (C) 2017 The Android Open Source Project
 *
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
package com.android.server.wifi;

import android.annotation.Nullable;
import android.hardware.wifi.V1_0.IWifi;
import android.hardware.wifi.V1_0.IWifiChip;
import android.hardware.wifi.V1_0.IWifiRttController;
import android.hardware.wifi.V1_0.IWifiStaIface;
import android.hardware.wifi.V1_0.WifiDebugHostWakeReasonStats;
import android.hardware.wifi.V1_0.WifiStatus;
import android.net.apf.ApfCapabilities;
import android.net.wifi.RttManager;
import android.net.wifi.RttManager.ResponderConfig;
import android.net.wifi.WifiLinkLayerStats;
import android.net.wifi.WifiScanner;
import android.net.wifi.WifiWakeReasonAndCounts;
import android.os.RemoteException;
import android.util.Log;

import com.android.server.connectivity.KeepalivePacketData;

/**
 * Vendor HAL via HIDL
 */
public class WifiVendorHal {

    private static final String TAG = "WifiVendorHal";

    // Vendor HAL HIDL interface objects.
    private IWifi mIWifi;
    private IWifiChip mIWifiChip;
    private IWifiStaIface mIWifiStaIface;
    private IWifiRttController mIWifiRttController;

    private void handleRemoteException(RemoteException e) {
        kilroy();
        Log.e(TAG, "RemoteException in HIDL call " + e);
    }

    private void noteHidlError(WifiStatus status, String culprit) {
        kilroy();
        Log.e(TAG, "Error in " + culprit + " code: " + status.code
                + " (" + status.description + ")");
    }

    /**
     * Bring up the HIDL Vendor HAL and configure for STA mode
     */
    public boolean startVendorHal() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Stops the HAL
     */
    public void stopVendorHal() {
        kilroy();
        // TODO(mplass): Actually stop b/33383725
        mIWifi = null;
        mIWifiChip = null;
        mDriverDescription = null;
        mFirmwareDescription = null;
        throw new UnsupportedOperationException();
    }

    /**
     * Tests whether the HAL is running or not
     */
    public boolean isHalStarted() {
        return mIWifiStaIface != null;
    }

    /**
     * Gets the scan capabilities
     *
     * @param capabilities object to be filled in
     * @return true for success. false for failure
     */
    public boolean getScanCapabilities(WifiNative.ScanCapabilities capabilities) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * to be implemented
     */
    public boolean startScan(WifiNative.ScanSettings settings,
                             WifiNative.ScanEventHandler eventHandler) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * to be implemented
     */
    public void stopScan() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * to be implemented
     */
    public void pauseScan() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * to be implemented
     */
    public void restartScan() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * to be implemented
     */
    public WifiScanner.ScanData[] getScanResults(boolean flush) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Get the link layer statistics
     *
     * @param iface is the name of the wifi interface (checked for null, otherwise ignored)
     * @return the statistics, or null if unable to do so
     */
    public WifiLinkLayerStats getWifiLinkLayerStats(String iface) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Enable link layer stats collection
     *
     * @param iface  is the name of the wifi interface (checked for null, otherwise ignored)
     * @param enable must be 1
     */
    public void setWifiLinkLayerStats(String iface, int enable) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Get the supported features
     *
     * @return bitmask defined by WifiManager.WIFI_FEATURE_*
     */
    public int getSupportedFeatureSet() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /* RTT related commands/events */

    /**
     * Starts a new rtt request
     *
     * @param params
     * @param handler
     * @return success indication
     */
    public boolean requestRtt(RttManager.RttParams[] params, WifiNative.RttEventHandler handler) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Cancels an outstanding rtt request
     *
     * @param params
     * @return true if there was an outstanding request and it was successfully cancelled
     */
    public boolean cancelRtt(RttManager.RttParams[] params) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Enables RTT responder role on the device.
     *
     * @return {@link ResponderConfig} if the responder role is successfully enabled,
     * {@code null} otherwise.
     */
    @Nullable
    public ResponderConfig enableRttResponder(int timeoutSeconds) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Disables RTT responder role.
     *
     * @return {@code true} if responder role is successfully disabled,
     * {@code false} otherwise.
     */
    public boolean disableRttResponder() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * not supported
     */
    public boolean setScanningMacOui(byte[] oui) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * not supported
     */
    public int[] getChannelsForBand(int band) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * not supported
     */
    public boolean isGetChannelsForBandSupported() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Set DFS - actually, this is always on.
     *
     * @param dfsOn
     * @return success indication
     */
    public boolean setDfsFlag(boolean dfsOn) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * RTT (Round Trip Time) measurement capabilities of the device.
     */
    public RttManager.RttCapabilities getRttCapabilities() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Get the APF (Android Packet Filter) capabilities of the device
     */
    public ApfCapabilities getApfCapabilities() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    private static final ApfCapabilities sNoApfCapabilities = new ApfCapabilities(0, 0, 0);

    /**
     * Installs an APF program on this iface, replacing an existing
     * program if present.
     */
    public boolean installPacketFilter(byte[] filter) {
        kilroy();
        throw new UnsupportedOperationException();
    }


    /**
     * to be implemented
     */
    public boolean setCountryCodeHal(String countryCode) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * not to be implemented
     */
    public boolean enableDisableTdls(boolean enable, String macAdd,
                                     WifiNative.TdlsEventHandler tdlsCallBack) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * not to be implemented
     */
    public WifiNative.TdlsStatus getTdlsStatus(String macAdd) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * not to be implemented
     */
    public WifiNative.TdlsCapabilities getTdlsCapabilities() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * to be implemented
     */
    public boolean setLoggingEventHandler(WifiNative.WifiLoggerEventHandler handler) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Control debug data collection
     *
     * @param verboseLevel       0 to 3, inclusive. 0 stops logging.
     * @param flags              Ignored.
     * @param maxIntervalInSec   Maximum interval between reports; ignore if 0.
     * @param minDataSizeInBytes Minimum data size in buffer for report; ignore if 0.
     * @param ringName           Name of the ring for which data collection is to start.
     * @return true for success
     */
    public boolean startLoggingRingBuffer(int verboseLevel, int flags, int maxIntervalInSec,
                                          int minDataSizeInBytes, String ringName) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Pointlessly fail
     *
     * @return -1
     */
    public int getSupportedLoggerFeatureSet() {
        return -1;
    }

    /**
     * to be implemented
     */
    public boolean resetLogHandler() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    private String mDriverDescription;

    /**
     * Vendor-provided wifi driver version string
     */
    public String getDriverVersion() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    private String mFirmwareDescription;

    /**
     * Vendor-provided wifi firmware version string
     */
    public String getFirmwareVersion() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * API to get the status of all ring buffers supported by driver
     */
    public WifiNative.RingBufferStatus[] getRingBufferStatus() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * indicates to driver that all
     * the data has to be uploaded urgently
     */
    public boolean getRingBufferData(String ringName) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * to be implemented via mIWifiChip.requestFirmwareDebugDump
     */
    public byte[] getFwMemoryDump() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Request vendor debug info from the driver
     */
    public byte[] getDriverStateDump() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Start packet fate monitoring
     * <p>
     * Once started, monitoring remains active until HAL is unloaded.
     *
     * @return true for success
     */
    public boolean startPktFateMonitoring() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Retrieve fates of outbound packets
     * <p>
     * Reports the outbound frames for the most recent association (space allowing).
     *
     * @param reportBufs
     * @return true for success
     */
    public boolean getTxPktFates(WifiNative.TxFateReport[] reportBufs) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Retrieve fates of inbound packets
     * <p>
     * Reports the inbound frames for the most recent association (space allowing).
     *
     * @param reportBufs
     * @return true for success
     */
    public boolean getRxPktFates(WifiNative.RxFateReport[] reportBufs) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Start sending the specified keep alive packets periodically.
     *
     * @return 0 for success, -1 for error
     */
    public int startSendingOffloadedPacket(
            int slot, KeepalivePacketData keepAlivePacket, int periodInMs) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Stop sending the specified keep alive packets.
     *
     * @param slot id - same as startSendingOffloadedPacket call.
     * @return 0 for success, -1 for error
     */
    public int stopSendingOffloadedPacket(int slot) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Start RSSI monitoring on the currently connected access point.
     *
     * @param maxRssi          Maximum RSSI threshold.
     * @param minRssi          Minimum RSSI threshold.
     * @param rssiEventHandler Called when RSSI goes above maxRssi or below minRssi
     * @return 0 for success, -1 for failure
     */
    public int startRssiMonitoring(byte maxRssi, byte minRssi,
                                   WifiNative.WifiRssiEventHandler rssiEventHandler) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Stop RSSI monitoring
     *
     * @return 0 for success, -1 for failure
     */
    public int stopRssiMonitoring() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    private WifiDebugHostWakeReasonStats mWifiDebugHostWakeReasonStats;

    /**
     * Fetch the host wakeup reasons stats from wlan driver.
     *
     * @return the |WifiWakeReasonAndCounts| object retrieved from the wlan driver.
     */
    public WifiWakeReasonAndCounts getWlanWakeReasonCount() {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Enable/Disable Neighbour discovery offload functionality in the firmware.
     */
    public boolean configureNeighborDiscoveryOffload(boolean enabled) {
        kilroy();
        throw new UnsupportedOperationException();
    }

    /**
     * Helper function that parses unquoted MAC address string to a byte array
     *
     * @param macWithColons mac address string without double quotes
     * @param mac an array of 6 bytes to receive the parsed mac address
     */
    private void parseUnquotedMacStrToByteArray(String macWithColons, byte[] mac) {
        String[] macAddrStr = macWithColons.split(":");
        for (int i = 0; i < 6; i++) {
            Integer hexVal = Integer.parseInt(macAddrStr[i], 16);
            mac[i] = hexVal.byteValue();
        }
    }

    StackTraceElement[] mTrace;

    private void kilroy() {
        Thread cur = Thread.currentThread();
        mTrace = cur.getStackTrace();
        StackTraceElement s = mTrace[3];
        String name = s.getMethodName();
        if (name.contains("lambda$")) {
            // Try to find a friendlier method name
            String myFile = s.getFileName();
            if (myFile != null) {
                for (int i = 4; i < mTrace.length; i++) {
                    if (myFile.equals(mTrace[i].getFileName())) {
                        name = mTrace[i].getMethodName();
                        break;
                    }
                }
            }
        }
        Log.e(TAG, "th " + cur.getId() + " line " + s.getLineNumber() + " " + name);
    }

}
