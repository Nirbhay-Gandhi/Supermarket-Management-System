<b>HashCode</b>
In Java, the hashCode method is used to generate a unique integer representation for an object. 
It is part of the Object class and is often overridden in custom classes for consistency with the equals method and proper functioning in collections like HashSet, HashMap, etc.

Here's a detailed explanation of hashCode and its use in HashSet:

<b> hashCode Method: </b>

<b> 1. Purpose: </b> <br/>

The primary purpose of hashCode is to provide a numeric representation of an object's state.
It is used by hash-based collections (e.g., HashSet, HashMap) to efficiently organize and locate objects. <br/>

<b> 2. Contract with equals: </b> <br/>

Objects that are equal according to the equals method must have the same hash code.
However, objects with the same hash code are not necessarily equal (to handle hash collisions). <br/>

<b> 3. Implementation: </b> <br/>

The default implementation in the Object class returns the memory address of the object in hexadecimal.
It is often overridden in custom classes to provide a more meaningful and consistent hash code. <br/>

<b> HashSet and hashCode: </b> <br/>

<b> 1. HashSet Internally Uses hashCode: </b> <br/>

In a HashSet, the hashCode method is used to determine the bucket in which an object should be stored.
Buckets are used to efficiently organize objects, and each bucket corresponds to a specific hash code. <br/>

<b> 2. Ensuring Proper Functioning: </b> <br/> 

To ensure that objects with the same logical content (according to equals) end up in the same bucket, it's crucial to override both equals and hashCode in the class.
Without a proper hashCode implementation, the HashSet might not function correctly, and you may observe unexpected behavior.

<b> 3. Example hashCode Implementation: </b> <br/>

A simple and effective way to implement hashCode for a class is to use the hash codes of its significant fields.
In your Product class, the hashCode method is overridden to use the hash code of the product_name field. <br/>


@Override </br>
public int hashCode() { </br>
    return product_name.hashCode(); </br>
} </br>

By providing a consistent and meaningful hashCode implementation, you ensure that objects are properly organized within hash-based collections, leading to efficient retrieval and storage. Always make sure that hashCode is consistent with equals to adhere to the general contract between these two methods.
