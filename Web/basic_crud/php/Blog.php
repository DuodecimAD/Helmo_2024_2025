<?php

namespace Blog\php;
require_once 'db.php';
class Blog
{
    private String $articleName;
    private String $authorName;
    private String $categoryName;
    private String $tagName;
    private String $description;
    private String $imageName;
    private String $link;

    /**
     * @param String $articleName
     * @param String $authorName
     * @param String $categoryName
     * @param String $tagName
     * @param String $description
     * @param String $imageName
     * @param String $link
     */
    public function __construct(string $articleName, string $authorName, string $categoryName, string $tagName, string $description, string $imageName, string $link)
    {
        $this->articleName = $articleName;
        $this->authorName = $authorName;
        $this->categoryName = $categoryName;
        $this->tagName = $tagName;
        $this->description = $description;
        $this->imageName = $imageName;
        $this->link = $link;
    }

    public function getArticleName(): string
    {
        return $this->articleName;
    }

    public function setArticleName(string $articleName): void
    {
        $this->articleName = $articleName;
    }

    public function getAuthorName(): string
    {
        return $this->authorName;
    }

    public function setAuthorName(string $authorName): void
    {
        $this->authorName = $authorName;
    }

    public function getCategoryName(): string
    {
        return $this->categoryName;
    }

    public function setCategoryName(string $categoryName): void
    {
        $this->categoryName = $categoryName;
    }

    public function getTagName(): string
    {
        return $this->tagName;
    }

    public function setTagName(string $tagName): void
    {
        $this->tagName = $tagName;
    }

    public function getDescription(): string
    {
        return $this->description;
    }

    public function setDescription(string $description): void
    {
        $this->description = $description;
    }

    public function getImageName(): string
    {
        return $this->imageName;
    }

    public function setImageName(string $imageName): void
    {
        $this->imageName = $imageName;
    }

    public function getLink(): string
    {
        return $this->link;
    }

    public function setLink(string $link): void
    {
        $this->link = $link;
    }

}