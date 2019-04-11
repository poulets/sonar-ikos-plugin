/*
 * This file is part of sonar-ikos-plugin.
 *
 * sonar-ikos-plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * sonar-ikos-plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with sonar-ikos-plugin.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.poulets.sonar.ikos;

import org.sonar.api.Plugin;

/**
 *
 * This class is the entry point for all extensions.
 *
 */
public class IkosPlugin implements Plugin {

	/**
	 * Define all extensions implemented by the plugin.
	 *
	 * @param context SonarQube context.
	 */
	@Override
	public void define(Context context) {
		// Setting plugin ikos
		context.addExtension(IkosLanguage.class);
		context.addExtension(IkosQualityProfiles.class);
		context.addExtensions(IkosPluginProperties.getProperties());

		// Rules definition
		context.addExtension(IkosRulesDefinition.class);

		// Sonar scanner extension
		context.addExtension(IkosSensor.class);
	}
}

