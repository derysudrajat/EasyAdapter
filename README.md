# EasyAdapter
Library to make your coding easy when create adapter

<img src="https://user-images.githubusercontent.com/32610660/142735095-78997cea-9103-4902-8618-0cc69de647a3.png" width = 40%>

[![](https://jitpack.io/v/derysudrajat/EasyAdapter.svg)](https://jitpack.io/#derysudrajat/EasyAdapter)

<table style="width:100%">
  <tr>
    <th colspan=2 >EasyAdapter</th>
  </tr>
  <tr>
    <td>ViewBinding Support</td>
    <td>✅</td>
  </tr>
  <tr>
    <td>100% Kotlin</td>
    <td>✅</td>
  </tr>
  <tr>
    <td>Compose Like Adapter</td>
    <td>✅</td>
  </tr>
    <tr>
    <td>Indexed Adapter</td>
    <td>✅</td>
  </tr>
  </tr>
    <tr>
    <td>Multi Easy Adapter</td>
    <td>✅</td>
  </tr>
  </tr>
    <tr>
    <td>Give Initial to Adapter</td>
    <td>✅</td>
  </tr>
  <tr>
    <td>Easy to use</td>
    <td>✅</td>
  </tr>
</table>

## Setup

### 1. Add the JitPack repository to your build file

Add it in your root `build.gradle` at the end of repositories:
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### 2. Add the dependency

```gradle
dependencies {
    implementation 'com.github.derysudrajat:EasyAdapter:2.0.0'
}
```

## How To Use

### 1. The new way to use EasyAdapter ⚡️
you just need to put your `listOfData` into `EasyAdapter` object along with your `ItemLayoutBinding` that call `::inflate` function 😎

```kotlin
binding.rvMain.adapter = EasyAdapter(listOfData, ItemDataBinding::inflate) { binding, data ->
    binding.tvName.text = data.name
    binding.tvId.text = data.id
    // ... other awesome code
}
```
### 2. EasyAdapter with Indexed 🥳
yes finally you can use `EasyAdapterIndexed` if you want an index of the data when it `onBind` 😎

```kotlin
binding.rvMain.adapter = EasyAdapterIndexed(listOfData, ItemDataBinding::inflate) { binding, data, index ->
    // .. your awesome code here
}
```
### 3. Multi EasyAdapter
Here we go to provide multiple views on `EasyAdapter` now you can do it with `MultipleEasyAdapter ` 🔥

- you can use `item` for single data like `separator` or `title`
- or you can use `items` for multiple data like the usual `EasyAdapter`

```kotlin
multipleAdapter = MultipleEasyAdapter {
    item("List with Items", ItemTextBinding::inflate) { binding, data ->
        binding.root.text = data
    }
    items(listOne, ItemDataBinding::inflate) { binding, data ->
        binding.tvName.text = data.name
        binding.tvId.text = data.id
    }
    item("List with ItemsIndexed", ItemTextBinding::inflate) { binding, data ->
        binding.root.text = data
    }
    itemsIndexed(listTwo, ItemDataBinding::inflate) { binding, data, index ->
        binding.tvName.text = buildString {
            append("This item number-${index + 1}: ${data.name}")
        }
        binding.tvId.text = data.id
    }
}
```

### 4. Using Existing EasyAdapter in MultipleEasyAdapter
if you wondering to using the existing `EasyAdapter` into`MultipleEasyAdapter` it's possible? yes absolutely possible 😎
- you can use `addAdapter(yourEasyDapter)` into `MultipleEasyAdapter`

```kotlin
multipleAdapter = MultipleEasyAdapter {
    item("List with addAdapter", ItemTextBinding::inflate) { binding, data ->
        binding.root.text = data
    }
    addAdapter(adapter)
    item("List with addAdapter Indexed", ItemTextBinding::inflate) { binding, data ->
        binding.root.text = data
    }
    addAdapter(adapterIndexed)
}
```

### 5. You can initial your EasyAdapter
yes if you using multiple adapter and want to using different data you can initial your adapter first just like this ✨

```kotlin
private var adapter = EasyAdapter.init<Data, ItemDataBinding>(ItemDataBinding::inflate)
private var adapterIndexed = EasyAdapterIndexed.init<Data, ItemDataBinding>(ItemDataBinding::inflate)
```

### 6. Attach your MultipleEasyAdapter
finally you can attach the`MultipleEasyAdapter` using `.assemble()` like this, ya you know it means you assemble all the adapter 😎

```kotlin
binding.rvMain.adapter = multipleAdapter.assemble()
```

Enjoy the library, give me star ⭐️ if you like this library, ciaao 😎✨
