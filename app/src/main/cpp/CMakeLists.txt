cmake_minimum_required(VERSION 3.18.1)
project("craftlink-renderer")

add_library(native-render SHARED
    native-lib.cpp
)

find_library(log-lib log)
find_library(android-lib android)

find_library(jnigraphics-lib jnigraphics)

target_link_libraries(native-render
    ${log-lib}
    ${android-lib}
    ${jnigraphics-lib}
)

target_compile_options(native-render PRIVATE
    -Wall
    -Wextra
    -O2
    -ffast-math
)
