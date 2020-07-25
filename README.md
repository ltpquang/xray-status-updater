# Xray Status Updater

This deadly simple package helps updating Xpand IT' [Xray](https://confluence.xpand-it.com/display/XRAY/v2.0) Test Run status.

## Installation

### Maven

**Step 1.** Add JitPack to your repositories

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

**Step 2.** Add Xray Status Updater to your dependencies

```
<dependency>
    <groupId>com.github.ltpquang</groupId>
    <artifactId>xray-status-updater</artifactId>
    <version>${version}</version>
</dependency>
```

### Gradle

**Step 1.** Add JitPack to your repositories

```
allprojects {
	repositories {
        ...
        maven { url 'https://jitpack.io' }
	}
}
```

**Step 2.** Add Xray Status Updater to your dependencies

```
dependencies {
    implementation "com.github.ltpquang:xray-status-updater:$version"
}
```

## Usage

**Step 1.** Create `XrayClient` instances with necessary parameters

```kotlin
val client = XrayClient("https://foosite.com", "username", "password")
```

**Step 2.** Set the Test Run to appropriate status, using Test Issue Key and Test Execution Issue Key

```kotlin
client.setStatus(testIssueKey, testExecIssueKey, Status.PASS)
```
