package com.misc.javadocs;

public class MyString {
	private char[] input;

	private char concat;

	MyString(char[] input) {
		this.input = input;
		createString();
	}

	private void createString() {
		for (int i = 0; i < input.length; i++) {
			concat = (char) (concat + input[i]);
			System.out.println(concat);
		}
		new immutableString(concat).get();
	}

	@Override
	public String toString() {
		return ""+concat;
	}

	private final class immutableString {
		private final char input;

		public immutableString(char input) {
			this.input = input;
		}

		public char get() {
			return this.input;
		}

		@Override
		public String toString() {
			return "immutableString : " + this.hashCode() + " : " + input;
		}
	}
}
