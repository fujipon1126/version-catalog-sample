module.exports = {
  branchPrefix: 'renovate/',
  dryRun: false,
  username: 'renovate-release',
  gitAuthor: 'Renovate Bot <bot@renovateapp.com>',
  platform: 'github',
  repositories: [
    'fujipon1126/version-catalog-sample'
  ],
  "labels": ["dependencies"],
  packageRules: [
    {
      // major,minor,patch以外のバージョンアップは無効
      matchUpdateTypes: [ 'pin', 'pinDigest', 'digest', 'lockFileMaintenance', 'rollback', 'bump'],
      enabled: false
    }
  ],
  extends: [ "config:base" ],
  ignorePresets: [":prHourlyLimit2", ":prConcurrentLimit10"]
};