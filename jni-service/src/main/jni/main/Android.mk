LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := jni-exec
LOCAL_SRC_FILES := main.cpp

LOCAL_LDFLAGS := -g -O0
#LOCAL_C_INCLUDES := $(LOCAL_PATH)/liba_src/include
#LOCAL_STATIC_LIBRARIES += debug
LOCAL_LDLIBS := -llog
#include $(BUILD_SHARED_LIBRARY)

LOCAL_CFLAGS += -pie -fPIE
LOCAL_LDFLAGS += -pie -fPIE

include $(BUILD_EXECUTABLE)

include $(clear_vars)

laocal_module :=jni_service
local_src_files := native-lib.cpp

local_c_include := $(local_path)/inlcude
#local_static_libraries +=
local_ldlibs := -llog

local_cflags +=
local_ldflags += -g -O0
include $(build_shared_library)
