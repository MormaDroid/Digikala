package mohsen.morma.digikala.data.remote.model.category

data class CategoryModel(
val tool : List<SubCategoryModel>,
val digital : List<SubCategoryModel>,
val mobile : List<SubCategoryModel>,
val supermarket :List<SubCategoryModel>,
val fashion : List<SubCategoryModel>,
val naive: List<SubCategoryModel>,
val toy: List<SubCategoryModel>,
val beauty: List<SubCategoryModel>,
val home: List<SubCategoryModel>,
val book: List<SubCategoryModel>,
val sport: List<SubCategoryModel>
)
