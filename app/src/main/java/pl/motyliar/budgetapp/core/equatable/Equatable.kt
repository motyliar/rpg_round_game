package pl.motyliar.budgetapp.core.equatable

import pl.motyliar.budgetapp.domain.character.subclass.Armor

open class Equatable {
  companion object {
      fun <T> getProps(main: T, other: Any?, ): Boolean {
          if (main === other) return true

          val fieldsMain = main!!::class.java.declaredFields
          val fieldsOther = other!!::class.java.declaredFields
          if (fieldsMain.size != fieldsOther.size) return false

          for (fieldMain in fieldsMain) {
              fieldMain.isAccessible = true
              val valueMain = fieldMain.get(main)
              val fieldOther = fieldsOther.find { it.name == fieldMain.name }
              if (fieldOther == null) return false
              fieldOther.isAccessible = true
              val valueOther = fieldOther.get(other)
              if (valueMain != valueOther) return false

              if (valueMain != null || valueOther != null) {
                  if (valueMain == null && valueOther == null) {
                      continue
                  } else if (valueMain == null || valueOther == null || valueMain != valueOther) {
                      return false
                  }
              }
          }

          return true
      }
  }}





