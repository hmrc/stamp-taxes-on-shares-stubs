val outputDir = file("./generated") // Directory for generated code

lazy val stubsProject = project.in(file("stubs"))
  .settings(

    cleanFiles += outputDir, // Clean up generated files

    openApiInputSpec := "./conf/api-specs/createStsSubscription.yaml", // Path to your OpenAPI spec
    openApiGeneratorName := "jaxrs-jersey", // Or another supported generator
    openApiOutputDir := "./generated/createStsSubscription", // Output directory for generated code

  )
