package com.pages;

import com.utills.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(), 'Parfum')]")
    private WebElement parfumButton;

    @FindBy(xpath = "//div[contains(text(),'Sale')]")
    private WebElement saleFilter;

    @FindBy(xpath = "//div[contains(text(),'Neu')]")
    private WebElement newFilter;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickParfum() {
        parfumButton.click();
    }

    public void applySaleFilter() {
        saleFilter.click();
    }

    public void applyNewFilter() {
        newFilter.click();
    }

}
