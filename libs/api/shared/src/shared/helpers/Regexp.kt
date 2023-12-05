package shared.helpers

object Regexp {
	const val ROLE_NAME = """^[A-Za-z][A-Za-z0-9\-+]{2,20}[A-Za-z0-9]$"""
	const val GROUP_NAME = """^[A-Za-z][A-Za-z0-9\s.\-+_]{2,20}[A-Za-z0-9]$"""
	const val PERMISSION_NAME = """^[A-Za-z][A-Za-z0-9.\-+_]{2,18}[A-Za-z0-9]$"""
	const val USERNAME = """^[A-Za-z0-9][A-Za-z0-9.\-+_$#@?]{3,19}"""
	const val PASSWORD = """.{8,}"""
	const val EMAIL = """^[A-Za-z0-9.+_-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}$"""
	const val HEXA = """^[a-fA-F0-9]+$"""
	const val DUPLICATE_KEY = """\{\s(?<name>\w+):\s"(?<value>\w*)"\s\}"""
}