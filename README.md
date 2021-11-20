# EasyAdapter
Library to create Recycle View without Adapter Class

<img src="https://user-images.githubusercontent.com/32610660/142735095-78997cea-9103-4902-8618-0cc69de647a3.png" width = 40%>

[![](https://jitpack.io/v/derysudrajat/EasyAdapter.svg)](https://jitpack.io/#derysudrajat/EasyAdapter)

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

### 3. Set adapter to RecycleView

```kotlin
rvMain.apply {
    setHasFixedSize(true)
    itemAnimator = DefaultItemAnimator()
    adapter = DataAdapter(Dummy.example) // just call adapter like hot 🔥
}
```
