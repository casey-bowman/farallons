load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")
load("@io_bazel_rules_groovy//groovy:groovy.bzl", "spock_test")

kt_jvm_library(
    name = "puffin",
    srcs = glob(["src/main/kotlin/**/*.kt"]),

)

spock_test(
    name = "puffin-test",
    specs = glob(["**/*.groovy"]),
    deps = [":puffin"],

)



