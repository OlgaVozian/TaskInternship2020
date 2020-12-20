package com.endava.internship.OOP;

import java.util.*;

import static java.util.stream.Collectors.toList;

public final class CharList {

    private List<Character> charList = new ArrayList<>();

    public CharList() {
    }

    public CharList(String value) {
        if (!value.isBlank()) {
            for (char c : value.toCharArray()) {
                charList.add(c);
            }
        } else {
            throw new IllegalArgumentException("Illegal argument passed");
        }
    }

    public CharList(List<Character> charList) {
        this.charList = charList;
    }

    int length() {
        return charList.size();
    }

    char charAt(int index) {
        return charList.get(index);
    }

    int indexOf(char c) {
        return charList.indexOf(c);
    }

    CharList subString(int start, int end) {
        return new CharList(charList.subList(start, end));
    }

    CharList removeDuplicates() {
        return new CharList(charList.stream()
                .distinct()
                .collect(toList()));
    }

    CharList replaceFirst(Character c) {
        charList.remove(c);
        return new CharList(charList);
    }

    CharList removeAll(Character c) {
        charList.removeAll(Arrays.asList(c));
        return new CharList(charList);
    }

    boolean isEmpty() {
        return charList.isEmpty();
    }

    boolean contains(Character c) {
        return charList.contains(c);
    }

    CharList clearList() {
        charList.clear();
        return new CharList(charList);
    }

    CharList sortList() {
        Collections.sort(charList);
        return new CharList(charList);
    }

    CharList reverseList() {
        charList.sort(Comparator.reverseOrder());
        return new CharList(charList);
    }

    CharList mixedList() {
        if (charList != null) {
            Collections.shuffle(charList);
        }
        return new CharList();
    }

    boolean trim() {
        if (charList.get(0) == ' ' || charList.get(charList.size() - 1) == ' ') {
            var existingValue = new StringBuilder();
            charList.forEach(existingValue::append);
            char[] chars = existingValue.toString().trim().toCharArray();
            charList.clear();
            for (char c : chars) {
                charList.add(c);
            }
            return true;
        }
        return false;
    }

    CharList replaceAll(CharList regex, CharList replacement) {
        var existingValue = new StringBuilder();
        var regexToBuilder = new StringBuilder();
        var replacementToBuilder = new StringBuilder();

        charList.forEach(existingValue::append);
        regex.charList.forEach(regexToBuilder::append);
        replacement.charList.forEach(replacementToBuilder::append);
        return new CharList(existingValue.toString().replaceAll(regexToBuilder.toString(), replacementToBuilder.toString()));
    }

    CharList replaceFirst(CharList regex, CharList replacement) {
        var existingValue = new StringBuilder();
        var regexToBuilder = new StringBuilder();
        var replacementToBuilder = new StringBuilder();

        charList.forEach(existingValue::append);
        regex.charList.forEach(regexToBuilder::append);
        replacement.charList.forEach(replacementToBuilder::append);
        return new CharList(existingValue.toString().replaceFirst(regexToBuilder.toString(), replacementToBuilder.toString()));
    }

    CharList concat(CharList charListToAdd) {
        if (charListToAdd != null) {
            charList.addAll(charListToAdd.charList);
        }
        return new CharList(charList);
    }

    boolean endsWith(CharList newCharList) {
        var existingValue = new StringBuilder();
        var newValue = new StringBuilder();

        charList.forEach(existingValue::append);
        newCharList.charList.forEach(newValue::append);
        return existingValue.toString().endsWith(newValue.toString());
    }

    CharList toLowerCase() {
        var existingValue = new StringBuilder();
        charList.forEach(existingValue::append);
        return new CharList(existingValue.toString().toLowerCase());
    }

    CharList toUpperCase() {
        var existingValue = new StringBuilder();
        charList.forEach(existingValue::append);
        return new CharList(existingValue.toString().toUpperCase());
    }

    boolean isPalindrome() {
        for (int i = 0, j = charList.size() - 1; i < charList.size() / 2; i++, j--) {
            if (charList.get(i) != charList.get(j)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharList charList1 = (CharList) o;
        return Objects.equals(charList, charList1.charList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charList);
    }

    @Override
    public String toString() {
        var text = new StringBuilder();
        charList.forEach(text::append);
        return text.toString();
    }
}
