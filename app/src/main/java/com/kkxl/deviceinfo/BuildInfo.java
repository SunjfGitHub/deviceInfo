package com.kkxl.deviceinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.kkxl.deviceinfo.infoManager.InfoManager;
import java.util.HashMap;

public class BuildInfo {

    @SuppressLint("MissingPermission")
    public static HashMap getAllBuildInfo(Context context) {
        HashMap info = new HashMap();
        info.put("bluetoothAddr", InfoManager.getInstance().getBluetoothAddr(context));
        info.put("imei", InfoManager.getInstance().getImei(context));
        info.put("imsi", InfoManager.getInstance().getImsi(context));
        info.put("phoneNumber", InfoManager.getInstance().getPhoneNumber(context));
        info.put("BOARD", Build.BOARD);
        info.put("BOOTLOADER", Build.BOOTLOADER);
        info.put("BRAND", Build.BRAND);
        info.put("DEVICE", Build.DEVICE);
        info.put("DISPLAY", Build.DISPLAY);
        info.put("FINGERPRINT", Build.FINGERPRINT);
        info.put("HARDWARE", Build.HARDWARE);
        info.put("MODEL", Build.MODEL);
        info.put("SERIAL", Build.SERIAL);
        info.put("RadioVersion", Build.getRadioVersion());
        info.put("CPU_ABI", Build.CPU_ABI);
        info.put("CPU_ABI2", Build.CPU_ABI2);
        info.put("HOST", Build.HOST);
        info.put("ID", Build.ID);
        info.put("TYPE", Build.TYPE);
        info.put("PRODUCT", Build.PRODUCT);
        info.put("MANUFACTURER", Build.MANUFACTURER);
        info.put("PRODUCT", Build.PRODUCT);
        info.put("TAGS", Build.TAGS);
        info.put("TIME", Build.TIME);
        info.put("sdk_version", android.os.Build.VERSION.SDK_INT);
        info.put("os_version", android.os.Build.VERSION.RELEASE);
        info.put("os_name", android.os.Build.DISPLAY);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            info.put("getSerial", Build.getSerial());
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            info.put("SUPPORTED_ABIS", Build.SUPPORTED_ABIS);
            info.put("SUPPORTED_32_BIT_ABIS", Build.SUPPORTED_32_BIT_ABIS);
            info.put("SUPPORTED_64_BIT_ABIS", Build.SUPPORTED_64_BIT_ABIS);
        }
        return info;
    }

    public static String[][] List = {
            {"ro.property_service.version", "描述"},
            {"ro.build.id", "描述"},
            {"ro.build.display.id", "描述"},
            {"ro.build.version.incremental", "描述"},
            {"ro.build.version.sdk", "描述"},
            {"ro.build.version.preview_sdk", "描述"},
            {"ro.build.version.codename", "描述"},
            {"ro.build.version.all_codenames", "描述"},
            {"ro.build.version.release", "描述"},
            {"ro.build.version.security_patch", "描述"},
            {"ro.build.version.base_os", "描述"},
            {"ro.build.date", "描述"},
            {"ro.build.date.utc", "描述"},
            {"ro.build.type", "描述"},
            {"ro.build.user", "描述"},
            {"ro.build.host", "描述"},
            {"ro.build.tags", "描述"},
            {"ro.build.flavor", "描述"},
            {"ro.product.model", "描述"},
            {"ro.product.brand", "描述"},
            {"ro.product.name", "描述"},
            {"ro.product.device", "描述"},
            {"ro.product.board", "描述"},
            {"ro.restart_level", "描述"},
            {"ro.product.cpu.abi", "描述"},
            {"ro.product.cpu.abilist", "描述"},
            {"ro.product.cpu.abilist32", "描述"},
            {"ro.product.cpu.abilist64", "描述"},
            {"ro.product.locale", "描述"},
            {"ro.wifi.channels", "描述"},
            {"ro.board.platform", "描述"},
            {"ro.build.product", "描述"},
            {"ro.build.description", "描述"},
            {"ro.build.fingerprint", "描述"},
            {"ro.build.characteristics", "描述"},
            {"ro.team.name", "描述"},
            {"ro.rom.author", "描述"},
            {"ro.rom.version", "描述"},
            {"rild.libpath", "描述"},
            {"rild.libargs", "描述"},
            {"persist.rild.nitz_plmn", "描述"},
            {"persist.rild.nitz_long_ons_0", "描述"},
            {"persist.rild.nitz_long_ons_1", "描述"},
            {"persist.rild.nitz_long_ons_2", "描述"},
            {"persist.rild.nitz_long_ons_3", "描述"},
            {"persist.rild.nitz_short_ons_0", "描述"},
            {"persist.rild.nitz_short_ons_1", "描述"},
            {"persist.rild.nitz_short_ons_2", "描述"},
            {"persist.rild.nitz_short_ons_3", "描述"},
            {"ril.subscription.types", "描述"},
            {"dEVICE_PROVISIONED", "描述"},
            {"ro.telephony.default_network", "描述"},
            {"debug.sf.hw", "描述"},
            {"debug.egl.hw", "描述"},
            {"persist.hwc.mdpcomp.enable", "描述"},
            {"debug.mdpcomp.logs", "描述"},
            {"dalvik.vm.heapsize", "描述"},
            {"dev.pm.dyn_samplingrate", "描述"},
            {"persist.demo.hdmirotationlock", "描述"},
            {"debug.enable.sglscale", "描述"},
            {"persist.speaker.prot.enable", "描述"},
            {"qcom.hw.aac.encoder", "描述"},
            {"persist.cne.feature", "描述"},
            {"media.msm8956hw", "描述"},
            {"mm.enable.smoothstreaming", "描述"},
            {"mmp.enable.3g2", "描述"},
            {"media.aac_51_output_enabled", "描述"},
            {"mm.enable.qcom_parser", "描述"},
            {"video.disable.ubwc", "描述"},
            {"persist.mm.sta.enable", "描述"},
            {"voice.playback.conc.disabled", "描述"},
            {"voice.record.conc.disabled", "描述"},
            {"voice.voip.conc.disabled", "描述"},
            {"voice.conc.fallbackpath", "描述"},
            {"audio.parser.ip.buffer.size", "描述"},
            {"persist.camera.is_type", "描述"},
            {"persist.camera.gyro.android", "描述"},
            {"ro.use_data_netmgrd", "描述"},
            {"persist.data.netmgrd.qos.enable", "描述"},
            {"persist.data.mode", "描述"},
            {"persist.timed.enable", "描述"},
            {"ro.qualcomm.cabl", "描述"},
            {"telephony.lteOnCdmaDevice", "描述"},
            {"bluetooth.hfp.client", "描述"},
            {"persist.fuse_sdcard", "描述"},
            {"ro.qc.sdk.audio.ssr", "描述"},
            {"ro.qc.sdk.audio.fluencetype", "描述"},
            {"persist.audio.fluence.voicecall", "描述"},
            {"persist.audio.fluence.voicerec", "描述"},
            {"persist.audio.fluence.speaker", "描述"},
            {"tunnel.audio.encode ", "描述"},
            {"audio.offload.buffer.size.kb", "描述"},
            {"audio.offload.min.duration.secs", "描述"},
            {"audio.offload.video", "描述"},
            {"audio.offload.pcm.16bit.enable", "描述"},
            {"audio.offload.pcm.24bit.enable", "描述"},
            {"audio.offload.track.enable", "描述"},
            {"audio.deep_buffer.media", "描述"},
            {"persist.audio.dirac.speaker", "描述"},
            {"audio.playback.mch.downsample", "描述"},
            {"use.voice.path.for.pcm.voip", "描述"},
            {"use.qti.sw.alac.decoder", "描述"},
            {"use.qti.sw.ape.decoder", "描述"},
            {"ro.fm.transmitter", "描述"},
            {"audio.offload.gapless.enabled", "描述"},
            {"audio.offload.multiple.enabled", "描述"},
            {"audio.safx.pbe.enabled", "描述"},
            {"audio.pp.asphere.enabled", "描述"},
            {"persist.debug.wfd.enable", "描述"},
            {"persist.hwc.enable_vds", "描述"},
            {"persist.debug.coresight.config", "描述"},
            {"ro.vendor.at_library", "描述"},
            {"ro.vendor.gt_library", "描述"},
            {"debug.enable.gamed", "描述"},
            {"vidc.enc.narrow.searchrange", "描述"},
            {"persist.qfp", "描述"},
            {"ro.core_ctl_min_cpu", "描述"},
            {"ro.core_ctl_max_cpu", "描述"},
            {"audio.dolby.ds2.enabled", "描述"},
            {"ro.hwui.texture_cache_size", "描述"},
            {"ro.hwui.layer_cache_size", "描述"},
            {"ro.hwui.r_buffer_cache_size", "描述"},
            {"ro.hwui.path_cache_size", "描述"},
            {"ro.hwui.gradient_cache_size", "描述"},
            {"ro.hwui.drop_shadow_cache_size", "描述"},
            {"ro.hwui.texture_cache_flushrate", "描述"},
            {"ro.hwui.text_small_cache_width", "描述"},
            {"ro.hwui.text_small_cache_height", "描述"},
            {"ro.hwui.text_large_cache_width", "描述"},
            {"ro.hwui.text_large_cache_height", "描述"},
            {"ro.sys.fw.bservice_enable", "描述"},
            {"ro.sys.fw.bservice_limit", "描述"},
            {"ro.sys.fw.bservice_age", "描述"},
            {"ro.sys.fw.use_trim_settings", "描述"},
            {"ro.sys.fw.empty_app_percent", "描述"},
            {"ro.sys.fw.trim_empty_percent", "描述"},
            {"ro.sys.fw.trim_cache_percent", "描述"},
            {"ro.sys.fw.trim_enable_memory", "描述"},
            {"ro.am.reschedule_service", "描述"},
            {"ro.sys.fw.dex2oat_thread_count", "描述"},
            {"ro.config.swap", "描述"},
            {"ro.cutoff_voltage_mv", "描述"},
            {"ro.emmc_size", "描述"},
            {"camera.hal1.packagelist", "描述"},
            {"camera.display.umax", "描述"},
            {"camera.display.lmax", "描述"},
            {"persist.radio.multisim.config", "描述"},
            {"persist.radio.force_on_dc", "描述"},
            {"persist.radio.VT_ENABLE ", "描述"},
            {"ro.ct.device.model", "描述"},
            {"persist.radio.DROPSETENABLE", "描述"},
            {"persist.data.iwlan.enable", "描述"},
            {"ro.fota.oem", "描述"},
            {"ro.build.software.version", "描述"},
            {"ro.miui.version.code_time", "描述"},
            {"ro.miui.ui.version.code", "描述"},
            {"ro.miui.ui.version.name", "描述"},
            {"persist.nfc.smartcard.config", "描述"},
            {"persist.sys.job_delay", "描述"},
            {"persist.sys.mcd_config_file", "描述"},
            {"persist.sys.perf.debug", "描述"},
            {"persist.sys.klo", "描述"},
            {"persist.sys.whetstone.level", "描述"},
            {"ro.ss.version", "描述"},
            {"ro.ss.nohidden", "描述"},
            {"dalvik.vm.heapminfree", "描述"},
            {"dalvik.vm.heapstartsize", "描述"},
            {"dalvik.vm.heapgrowthlimit", "描述"},
            {"dalvik.vm.heapsize", "描述"},
            {"dalvik.vm.heaptargetutilization", "描述"},
            {"dalvik.vm.heapmaxfree", "描述"},
            {"ro.carrier", "描述"},
            {"ro.vendor.extension_library", "描述"},
            {"persist.radio.sib16_support", "描述"},
            {"persist.radio.custom_ecc", "描述"},
            {"ro.frp.pst", "描述"},
            {"af.fast_track_multiplier", "描述"},
            {"audio_hal.period_size", "描述"},
            {"ro.malloc.impl", "描述"},
            {"persist.sys.dalvik.vm.lib.2", "描述"},
            {"dalvik.vm.isa.arm64.variant", "描述"},
            {"dalvik.vm.isa.arm64.features", "描述"},
            {"dalvik.vm.isa.arm.variant", "描述"},
            {"dalvik.vm.isa.arm.features", "描述"},
            {"net.bt.name", "描述"},
            {"dalvik.vm.stack-trace-file", "描述"},
            {"ro.miui.has_real_blur", "描述"},
            {"ro.miui.has_handy_mode_sf", "描述"},
            {"fw.max_users", "描述"},
            {"persist.radio.calls.on.ims", "描述"},
            {"persist.radio.jbims", "描述"},
            {"persist.radio.csvt.enabled", "描述"},
            {"persist.radio.rat_on", "描述"},
            {"persist.radio.mt_sms_ack", "描述"},
            {"ro.mdtp.package_name2", "描述"},
            {"ro.config.sms_received_sound", "描述"},
            {"ro.config.sms_delivered_sound", "描述"},
            {"ro.com.android.mobiledata", "描述"},
            {"ro.product.manufacturer", "描述"},
            {"ro.config.elder-ringtone", "描述"},
            {"keyguard.no_require_sim", "描述"},
            {"ro.com.android.dataroaming", "描述"},
            {"persist.sys.mitalk.enable", "描述"},
            {"ro.config.ringtone", "描述"},
            {"ro.config.notification_sound", "描述"},
            {"ro.config.alarm_alert", "描述"},
            {"ro.product.cuptsm", "描述"},
            {"persist.power.useautobrightadj", "描述"},
            {"persist.radio.apm_sim_not_pwdn", "描述"},
            {"qemu.hw.mainkeys", "描述"},
            {"persist.dbg.volte_avail_ovr", "描述"},
            {"persist.dbg.vt_avail_ovr", "描述"},
            {"ro.com.google.clientidbase", "描述"},
            {"ro.expect.recovery_id", "描述"},
            {"ro.adb.secure", "描述"},
            {"persist.sys.ui.hw", "描述"},
            {"persist.sys.device_name", "描述"},
            {"persist.service.adb.enable", "描述"},
            {"authorid", "描述"},
            {"persist.fastboot.enable", "描述"},
            {"ro.sf.lcd_density", "描述"}
    };

}
