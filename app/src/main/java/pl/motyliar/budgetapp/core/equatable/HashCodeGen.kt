package pl.motyliar.budgetapp.core.equatable

class HashCodeGen {
    companion object {
        private const val  HASH_MULTIPLER : Int = 31
        fun <T> generate(main: T): Int {
            var result = 0
            val fieldsMain = main!!::class.java.declaredFields
            for (field in fieldsMain) {
                field.isAccessible = true
                if (result == 0) {
                    result = field.hashCode()
                } else {
                    result = HASH_MULTIPLER * result + field.hashCode()
                }

            }
            return result

        }
    }
}