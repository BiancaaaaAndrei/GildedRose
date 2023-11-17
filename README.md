# Gilded Rose Inventory Management System

This is a Java implementation of the Gilded Rose inventory management system. The system is designed to handle different types of items and update their quality and sellIn values based on certain rules.Main problem the Gilded Rose system is designed to solve: managing a diverse inventory of items with different rules for quality and sellIn updates as well as refactoring the code.

## Introduction

The Gilded Rose inventory management system is a Java application that provides a flexible solution for managing the quality and sellIn values of various items. The system is built with extensibility in mind, allowing easy integration of new item types.

## Item Types

- **Normal Item**: Regular items that degrade in quality over time.
- **Aged Brie**: Quality increases as it gets older.
- **Backstage Pass**: Quality increases as the concert date approaches, but drops to 0 after the concert.
- **Sulfuras**: A legendary item with a constant quality of 80.
- **Conjured Item**: Degrades in quality twice as fast as normal items.