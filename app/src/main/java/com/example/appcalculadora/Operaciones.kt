package com.example.appcalculadora

import kotlin.time.measureTime

class Operaciones (var num1:Float, var num2: Float) {
    //var val
    // constructores get/set
    public fun suma() : Float{
        return this.num1 + this.num2
    }

    public fun resta() : Float{
        return this.num1 - this.num2
    }

    public fun multiplica() : Float{
        return this.num1 * this.num2
    }

    public  fun dividir() : Float{
        return this.num1 / this.num2
    }
}