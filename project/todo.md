ParseTreeProperty -> annotate tree about types (on expressions, including expressions that are only STRINGS/INTS/...) (Visitor)
enum class TugaType -> has "error" type, "any" operating with "error" = "error".
flag para dizer onde esta o erro de parsing (ex: "ola" * 2 + 7)

to see in what line it is we can use (on ctx), getStart() and getStop() and from the tokens get the getLine()
