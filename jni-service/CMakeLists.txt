
cmake_minimum_required(VERSION 3.4.1)


add_library( native-lib
             SHARED
             src/main/jni/native-lib.cpp
            )

find_library(log-lib
              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

target_link_libraries( # Specifies the target library.
                       native-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )

#include_directories("${PROJECT_BINARY_DIR}")
add_executable( jni_service
                src/main/jni/main.cpp
                )
target_link_libraries( # Specifies the target library.
                jni_service
                      ${log-lib} )