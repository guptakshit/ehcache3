package org.ehcache.build.plugins.osgids;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.TaskProvider;

public class OsgiDsPlugin implements Plugin<Project> {
  @Override
  public void apply(Project project) {
    project.getExtensions().getByType(SourceSetContainer.class).configureEach(sourceSet -> {
      TaskProvider<GenerateDeclarativeServicesDescriptors> generateTask = project.getTasks().register(sourceSet.getTaskName("generate", "DeclarativeServicesDescriptors"), GenerateDeclarativeServicesDescriptors.class, task -> {
        task.setDescription("Generate OSGi Declarative Services XML descriptors for " + sourceSet.getName() + " classes");
        task.getInputFiles().from(sourceSet.getOutput().getClassesDirs());
        task.getClasspath().from(sourceSet.getRuntimeClasspath());
        task.getOutputDirectory().set(project.getLayout().getBuildDirectory().dir("generated/osgids/" + sourceSet.getName()));
      });
      sourceSet.getOutput().getGeneratedSourcesDirs().plus(project.fileTree(generateTask));
    });
  }
}
