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
    <td>Create Adapter With or Without Class</td>
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
    implementation 'com.github.derysudrajat:EasyAdapter:1.0.0'
}
```

## How To Use

### 1. Make your adapter class extend to `EasyAdapter` class

in `EasyAdapter` class you need to define:

* `YourAdapterClass` = is your adapter class
* `YourDataClass` = is your item data class
* `YourLayoutBindingClass` = is your layout binding class


```kotlin
class YourAdapterClass(
    listOfData: List<YourDataClass>
) : EasyAdapter<YourDataClass, YourLayoutBindingClass>(listOfData)
```

### 2. Implement all method with your business logic

```kotlin
class DataAdapter(
    listOfData: MutableList<Data>
) : EasyAdapter<Data, ItemDataBinding>(listOfData) {
    
    // Infate your LayoutBinding class
    
    override fun create(parent: ViewGroup): ItemDataBinding {
        return ItemDataBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    }

    // Implement your business logic here
    
    override fun onBind(binding: ItemDataBinding, data: Data) {
        binding.apply {
            tvName.text = data.name
            tvId.text = data.id
        }
    }
}
```
### 3. Another way to Implement EasyAdapter

If you want to create adapter without class, yes we can, here we go 🔥

```kotlin
val dataAdapter = object : EasyAdapter<Data, ItemDataBinding>(Dummy.example){
    override fun create(parent: ViewGroup): ItemDataBinding {
        return ItemDataBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    }

    override fun onBind(binding: ItemDataBinding, data: Data) {
        with(binding){
            tvName.text = data.name
            tvId.text = data.id
        }
    }
}
```
### 4. Set adapter to RecycleView

Adapter with class

```kotlin
rvMain.apply {
    setHasFixedSize(true)
    itemAnimator = DefaultItemAnimator()
    adapter = DataAdapter(Dummy.example) // just call adapter like hot 🔥
}
```

Adapter without calss

```kotlin
rvMain.apply {
    setHasFixedSize(true)
    itemAnimator = DefaultItemAnimator()
    adapter = dataAdapter // just call adapter variable like hot 🔥
}
```
