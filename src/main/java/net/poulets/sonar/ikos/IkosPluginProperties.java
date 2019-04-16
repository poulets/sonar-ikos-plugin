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

import org.sonar.api.PropertyType;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Executed during sonar-scanner call.
 * This Sensor is able to:
 *  - Import ikos reports into SonarQube.
 *  - Run a specified external version of ikos.
 *
 */
public class IkosPluginProperties {

    /**
     * ikos default location's path value
     */
    private static final String IKOS_PATH_DEFAULT = "${HOME}/ikos/ikos";
    /**
     * Prefix used by all properties of this plugin
     **/
    private static final String PROPERTIES_PREFIX = "sonar.ikos.";
    /**
     * ikos name
     **/
    public static final String IKOS_NAME = "ikos";

    // project code file patterns
    /**
     * Key for the C suffix property
     **/
    public static final String C_SUFFIX_KEY = PROPERTIES_PREFIX + "c.file.suffixes";
    /**
     * Default value for the code suffix property
     **/
    public static final String C_SUFFIX_DEFAULT = ".sh,.ksh,.bash";
    /**
     * Name for the code suffix property
     **/
    public static final String C_SUFFIX_NAME = "C File Suffixes";
    /**
     * Description for the code suffix property
     **/
    public static final String C_SUFFIX_DESC = "List of suffixes for C files to analyze.";

    // Reports path
    /**
     * Key for the report path property
     **/
    public static final String REPORT_PATH_KEY = PROPERTIES_PREFIX + "reports.path";
    /**
     * Name for the report path property
     **/
    public static final String REPORT_PATH_NAME = "Report files";
    /**
     * Description for the report path property
     **/
    public static final String REPORT_PATH_DESC = "Path to the ikos reports. Multiple path can be provided.";
    /**
     * Default value for the report path property
     **/
    public static final String REPORT_PATH_DEFAULT = "";
    /**
     * ikos launching mode key
     */
    public static final String AUTOLAUNCH_PROP_KEY = PROPERTIES_PREFIX + "launch";
    /**
     * ikos launching mode default value
     */
    public static final String AUTOLAUNCH_PROP_DEFAULT = "false";
    /**
     * Launching mode name
     */
    public static final String AUTOLAUNCH_PROP_NAME = "ikos auto-launch";
    /**
     * Launching mode description
     */
    public static final String AUTOLAUNCH_PROP_DESC = "Auto-launch ikos on analysis using indicated location.";
    /**
     * ikos location's path key
     */
    public static final String IKOS_PATH_KEY = PROPERTIES_PREFIX + "path";
    /**
     * ikos location's path name
     */
    public static final String IKOS_PATH_NAME = "ikos location";
    /**
     * ikos location's path description
     */
    public static final String IKOS_PATH_DESC = "Define ikos executable path to auto-launch it on analysis.";

    private IkosPluginProperties() {
        super();
    }

    /**
     * Plugin properties extensions.
     *
     * @return The list of built properties.
     */
    public static List<PropertyDefinition> getProperties() {
        return Arrays.asList(
                PropertyDefinition.builder(AUTOLAUNCH_PROP_KEY)
                        .defaultValue(AUTOLAUNCH_PROP_DEFAULT)
                        .category(IKOS_NAME)
                        .name(AUTOLAUNCH_PROP_NAME)
                        .description(AUTOLAUNCH_PROP_DESC)
                        .type(PropertyType.BOOLEAN)
                        .onQualifiers(Qualifiers.PROJECT)
                        .build()
                ,
                PropertyDefinition.builder(IKOS_PATH_KEY)
                        .defaultValue(IKOS_PATH_DEFAULT)
                        .category(IKOS_NAME)
                        .name(IKOS_PATH_NAME)
                        .description(IKOS_PATH_DESC)
                        .onQualifiers(Qualifiers.PROJECT)
                        .build()
                ,
                PropertyDefinition.builder(C_SUFFIX_KEY).multiValues(true)
                        .defaultValue(C_SUFFIX_DEFAULT).category(IKOS_NAME)
                        .name(C_SUFFIX_NAME).description(C_SUFFIX_DESC)
                        .onQualifiers(Qualifiers.PROJECT)
                        .build()
                ,
                PropertyDefinition.builder(REPORT_PATH_KEY).multiValues(true)
                        .defaultValue(REPORT_PATH_DEFAULT).category(IKOS_NAME)
                        .name(REPORT_PATH_NAME).description(REPORT_PATH_DESC)
                        .onQualifiers(Qualifiers.PROJECT)
                        .build());
    }
}
