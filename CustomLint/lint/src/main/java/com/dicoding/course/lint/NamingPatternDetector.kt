package com.dicoding.course.lint

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement

@Suppress("UnstableApiUsage")
class NamingPatternDetector: Detector(), Detector.UastScanner {
    companion object{
        val ISSUNE_NAMING_PATTERN: Issue = Issue.create(
            id = "NamingPattern",
            briefDescription = "Penulisan nama harus menggunakan camel case.",
            explanation = """
                Tulis nama class dengan menggunakan CamelCase.
                Lihat contoh yang benar di https://google.github.io/styleguide/javaguide.html#s5.3-camel-case 
            """,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                NamingPatternDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(UClass::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler(){
            override fun visitClass(node: UClass) {
                if (node.name?.isDefinedCamelCase() == false){
                    context.report(
                        ISSUNE_NAMING_PATTERN,
                        node,
                        context.getNameLocation(node),
                        "Penulisan Nama Class Harus menggunakan Camel Case"
                    )
                }
            }
        }
    }

    private fun String.isDefinedCamelCase(): Boolean{
        val charArray = toCharArray()
        return charArray
            .mapIndexed { index, c ->
                c to charArray.getOrNull(index+1)
            }.none {
                it.first.isUpperCase() && it.second?.isUpperCase() ?: false
            }
    }

}